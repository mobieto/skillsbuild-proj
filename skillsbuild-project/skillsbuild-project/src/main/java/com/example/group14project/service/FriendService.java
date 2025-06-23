package com.example.group14project.service;

import com.example.group14project.domain.SkillsBuildUser;
import com.example.group14project.repo.SkillsBuildUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FriendService {
    @Autowired
    private SkillsBuildUserRepository skillsBuildUserRepository;

    private void removeUserFromList(List<SkillsBuildUser> list, SkillsBuildUser user) { // Cant use remove() directly on list because object references diff
        for (SkillsBuildUser _user : list) {
            if (_user.getName().equals(user.getName())) {
                list.remove(_user);
                break;
            }
        }
    }

    private boolean userExistsInList(List<SkillsBuildUser> list, SkillsBuildUser user) {
        for (SkillsBuildUser _user : list) {
            if (_user.getName().equals(user.getName())) {
                return true;
            }
        }

        return false;
    }

    // Send friend request, add to sender's outgoing friend requests and to receiver's incoming friend requests
    public String sendFriendRequest(String senderName, String receiverName) {
        SkillsBuildUser sender = skillsBuildUserRepository.findByName(senderName);
        SkillsBuildUser receiver = skillsBuildUserRepository.findByName(receiverName);

        if (receiver == null) { return "We couldn't find that user, please check your spelling and try again."; }

        if (receiver.getName().equals(senderName)) { return "You can't friend yourself."; }

        if (userExistsInList(sender.getFriends(), receiver)) { return "That user is already your friend."; }

        if (userExistsInList(sender.getOutgoingFriendRequests(), receiver)) { return "You already have a pending friend request to %s.".formatted(receiver.getName()); }

        if (userExistsInList(sender.getIncomingFriendRequests(), receiver)) { return this.acceptFriendRequest(senderName, receiverName); }

        sender.getOutgoingFriendRequests().add(receiver);
        receiver.getIncomingFriendRequests().add(sender);

        skillsBuildUserRepository.save(sender);
        skillsBuildUserRepository.save(receiver);

        return "Success! Your friend request to %s was sent.".formatted(receiver.getName());
    }

    // Remove from sender's outgoing friend requests and receiver's incoming friend requests
    public String removeFriendRequest(String senderName, String receiverName) {
        SkillsBuildUser sender = skillsBuildUserRepository.findByName(senderName);
        SkillsBuildUser receiver = skillsBuildUserRepository.findByName(receiverName);

        // Sanity checks just in case
        if (receiver == null || sender.getName().equals(receiver.getName()) || !userExistsInList(sender.getOutgoingFriendRequests(), receiver)) { return "Something went wrong. Please try again."; }

        removeUserFromList(sender.getOutgoingFriendRequests(), receiver);
        removeUserFromList(receiver.getIncomingFriendRequests(), sender);

        skillsBuildUserRepository.save(sender);
        skillsBuildUserRepository.save(receiver);

        return "Friend request to %s was successfully removed.".formatted(receiver.getName());
    }

    // Accept an incoming friend request
    public String acceptFriendRequest(String senderName, String receiverName) {
        SkillsBuildUser sender = skillsBuildUserRepository.findByName(senderName);
        SkillsBuildUser receiver = skillsBuildUserRepository.findByName(receiverName);

        // Sanity checks just in case
        if (receiver == null || sender.getName().equals(receiver.getName()) || !userExistsInList(receiver.getIncomingFriendRequests(), sender)) { return "Something went wrong. Please try again."; }

        removeUserFromList(sender.getOutgoingFriendRequests(), receiver);
        removeUserFromList(receiver.getIncomingFriendRequests(), sender);
        sender.getFriends().add(receiver);
        receiver.getFriends().add(sender);

        skillsBuildUserRepository.save(sender);
        skillsBuildUserRepository.save(receiver);

        return "%s is now your friend!".formatted(sender.getName());
    }

    // Remove friend from user's friends list
    public String removeFriend(String userName, String friendName) {
        SkillsBuildUser user = skillsBuildUserRepository.findByName(userName);
        SkillsBuildUser friend = skillsBuildUserRepository.findByName(friendName);

        // Sanity checks just in case
        if (friend == null || user.getName().equals(friend.getName()) || !userExistsInList(user.getFriends(), friend)) { return "Something went wrong. Please try again."; }

        removeUserFromList(user.getFriends(), friend);
        removeUserFromList(friend.getFriends(), user);

        skillsBuildUserRepository.save(user);
        skillsBuildUserRepository.save(friend);

        return "Successfully unfriended %s.".formatted(friend.getName());
    }
}
