package io.cagatay.testinstance;
import io.cagatay.testinstance.io.UsersDatabase;
import io.cagatay.testinstance.io.UsersDatabaseMapImpl;
import io.cagatay.testinstance.service.UserService;
import io.cagatay.testinstance.service.UserServiceImpl;
import org.junit.jupiter.api.*;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;


@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class UserServiceImplTest {

    UsersDatabase usersDatabase;
    UserService userService;
    String createdUserId="";

    @BeforeAll
    void setup() {
        // Create & initialize database
        this.usersDatabase = new UsersDatabaseMapImpl();
        this.usersDatabase.init();
        this.userService = new UserServiceImpl(usersDatabase);
    }

    @AfterAll
    void cleanup() {
        // Close connection
        // Delete database
        usersDatabase.close();
    }

    @Test
    @Order(1)
    @DisplayName("Create User works")
    void testCreateUser_whenProvidedWithValidDetails_returnsUserId() {
        //Arrange
        Map<String, String> user = new HashMap<>();
        user.put("firstName", "Cagatay");
        user.put("lastName", "Yilmaz");

        //Act
        this.createdUserId = userService.createUser(user);

        //Assert
        assertNotNull(this.createdUserId, "User id must be not null");

    }


    @Test
    @Order(2)
    @DisplayName("Update user works")
    void testUpdateUser_whenProvidedWithValidDetails_returnsUpdatedUserDetails() {
        //Arrange
        Map<String, String> newUserDetails = new HashMap<>();
        newUserDetails.put("firstName", "Recep");
        newUserDetails.put("lastName", "Ayan");

        //Act
        Map updatedUserDetails = userService.updateUser(createdUserId, newUserDetails);

        //Assert
        assertEquals(newUserDetails.get("firstname"), updatedUserDetails.get("firstname"),"" +
                "Values does not match" );
        assertEquals(newUserDetails.get("lastname"), updatedUserDetails.get("lastname"),"" +
                "Values does not match" );

    }

    @Test
    @Order(3)
    @DisplayName("Find user works")
    void testGetUserDetails_whenProvidedWithValidUserId_returnsUserDetails() {
        //Act
        Map userDetails = userService.getUserDetails(this.createdUserId);

        //Assert
        assertNotNull(userDetails, "user details is null");
        assertEquals(createdUserId, userDetails.get("userId"),
                "Returned user id is wrong");

    }

    @Test
    @Order(4)
    @DisplayName("Delete user works")
    void testDeleteUser_whenProvidedWithValidUserId_returnsUserDetails() {
        //Act
        userService.deleteUser(createdUserId);

        //Assert
        assertNull(userService.getUserDetails(createdUserId), "user must be empty");
    }

}