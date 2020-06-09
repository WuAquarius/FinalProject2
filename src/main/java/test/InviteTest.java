package test;

import dao.Invite;

/**
 * @author wunu
 * @create 2020-06-07 23:27
 * 描述:
 */
public class InviteTest {
    public static void main(String[] args) {
        Boolean inviteInfo = Invite.findInviteInfo("123456");
        System.out.println(inviteInfo);
    }
}
