package service;

import dao.Invite;

/**
 * @author wunu
 * @create 2020-06-07 23:49
 * 描述: 判断邀请码是否正确
 */
public class InviteService {
    public boolean inviteCheck(String key){
        return Invite.findInviteInfo(key);
    }
}
