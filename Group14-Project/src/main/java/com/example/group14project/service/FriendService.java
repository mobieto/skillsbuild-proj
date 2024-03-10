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

    // Send friend request, add to sender's outgoing friend requests and to receiver's incoming friend requests
    public void sendFriendRequest(String senderName, String receiverName) {
        SkillsBuildUser sender = skillsBuildUserRepository.findByName(senderName);
        SkillsBuildUser receiver = skillsBuildUserRepository.findByName(receiverName);

        sender.getOutgoingFriendRequests().add(receiver);
        receiver.getIncomingFriendRequests().add(sender);

        skillsBuildUserRepository.save(sender);
        skillsBuildUserRepository.save(receiver);
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

        sender.getOutgoingFriendRequests().add(receiver);
        receiver.getIncomingFriendRequests().add(sender);
        sender.getFriends().remove(receiver);
        receiver.getFriends().remove(sender);

        skillsBuildUserRepository.save(sender);
        skillsBuildUserRepository.save(receiver);
    }

    // Remove friend from user's friends list
    public void removeFriend(String userName, String friendName) {
        SkillsBuildUser user = skillsBuildUserRepository.findByName(userName);
        SkillsBuildUser friend = skillsBuildUserRepository.findByName(friendName);

        user.getFriends().remove(friend);
        friend.getFriends().remove(user);

        skillsBuildUserRepository.save(user);
        skillsBuildUserRepository.save(friend);
    }
}
