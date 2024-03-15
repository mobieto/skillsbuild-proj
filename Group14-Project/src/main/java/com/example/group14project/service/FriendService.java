package com.example.group14project.service;

import com.example.group14project.domain.SkillsBuildUser;
import com.example.group14project.repo.SkillsBuildUserRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FriendService {
    @Autowired
    private SkillsBuildUserRepository skillsBuildUserRepository;

    // Send friend request, add to sender's outgoing friend requests and to receiver's incoming friend requests
    public String sendFriendRequest(String senderName, String receiverName) {
        SkillsBuildUser sender = skillsBuildUserRepository.findByName(senderName);
        SkillsBuildUser receiver = skillsBuildUserRepository.findByName(receiverName);

        if (receiverName.equals(senderName)) { return "You can't add yourself :D"; }

        if (receiver == null) { return "We couldn't find that user, please try again."; }

        if (receiver.getFriends().contains(sender)) { return "That user is already your friend."; }

        sender.getOutgoingFriendRequests().add(receiver);
        receiver.getIncomingFriendRequests().add(sender);

        skillsBuildUserRepository.save(sender);
        skillsBuildUserRepository.save(receiver);

        return "Success! Your friend request to %s was sent.".formatted(receiverName);
    }

    // Remove from sender's outgoing friend requests and receiver's incoming friend requests
    public void removeFriendRequest(String senderName, String receiverName) {
        SkillsBuildUser sender = skillsBuildUserRepository.findByName(senderName);
        SkillsBuildUser receiver = skillsBuildUserRepository.findByName(receiverName);

        sender.getOutgoingFriendRequests().remove(receiver);
        receiver.getIncomingFriendRequests().remove(sender);

        skillsBuildUserRepository.save(sender);
        skillsBuildUserRepository.save(receiver);
    }

    // Accept an incoming friend request
    public void acceptFriendRequest(String senderName, String receiverName) {
        SkillsBuildUser sender = skillsBuildUserRepository.findByName(senderName);
        SkillsBuildUser receiver = skillsBuildUserRepository.findByName(receiverName);

        sender.getOutgoingFriendRequests().remove(receiver);
        receiver.getIncomingFriendRequests().remove(sender);
        sender.getFriends().add(receiver);
        receiver.getFriends().add(sender);

        skillsBuildUserRepository.save(sender);
        skillsBuildUserRepository.save(receiver);
    }

    // Remove friend from user's friends list
    public String removeFriend(String userName, String friendName) {
        SkillsBuildUser user = skillsBuildUserRepository.findByName(userName);
        SkillsBuildUser friend = skillsBuildUserRepository.findByName(friendName);

        user.getFriends().remove(friend);
        friend.getFriends().remove(user);

        skillsBuildUserRepository.save(user);
        skillsBuildUserRepository.save(friend);

        return "Success! %s is no longer your friend.".formatted(friendName);
    }
}
