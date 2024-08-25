package ku.cs.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserListTest {
    UserList userList;
    // TODO: add 3 users to UserList
    @BeforeEach
    void init() {
        userList = new UserList();
        userList.addUser("user01", "plain-p@ssw0rd1");
        userList.addUser("user02", "plain-p@ssw0rd2");
        userList.addUser("user03", "plain-p@ssw0rd3");
    }

    @Test
    @DisplayName("User should be found in UserList")
    public void testUserListFindUser() {
        // TODO: find one of them
        User user = userList.findUserByUsername("user02");
        // TODO: assert that UserList found User
        String expected = "user02";
        String actual = user.getUsername();
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("User can change password")
    public void testUserCanChangePassword() {
        // TODO: change password of one user
        boolean actual = userList.changePassword("user02","plain-p@ssw0rd2","plain-p@ssw0rd12345");
        // TODO: assert that user can change password
        assertTrue(actual);
    }

    @Test
    @DisplayName("User with correct password can login")
    public void testUserListShouldReturnObjectIfUsernameAndPasswordIsCorrect() {
        // TODO: call login() with correct username and password
        User actual = userList.login("user01", "plain-p@ssw0rd1");
        // TODO: assert that User object is found
        assertNotNull(actual);
        User expected = userList.findUserByUsername("user01");
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("User with incorrect password cannot login")
    public void testUserListShouldReturnNullIfUsernameAndPasswordIsIncorrect() {
        // TODO: call login() with incorrect username or incorrect password
        User actual = userList.login("user01", "wrong-password");
        // TODO: assert that the method return null
        assertNull(actual);
    }

}