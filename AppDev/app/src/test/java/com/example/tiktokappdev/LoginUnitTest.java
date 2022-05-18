package com.example.tiktokappdev;

import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import android.os.Bundle;

import com.example.tiktokappdev.DataManagers.UserDetailsDataManager;
import com.example.tiktokappdev.DataModels.UserDetailsDataModel;

import org.junit.Test;
import org.junit.Assert;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class LoginUnitTest {

    @Mock
    Bundle mockBundle;

    @Test
    public void login_isSuccessful() {
        // Create Mocks
        MainActivity myObjectUnderTest = mock(MainActivity.class);
        UserDetailsDataManager udom = mock(UserDetailsDataManager.class);
        myObjectUnderTest.UDDM = udom;

        // Mock data
        String username = "user";
        String name = "testName";
        String roles = "testRole";
        String email = "test@abc.com";
        String contactNumber = "+65 98765432";
        String dob = "01012000";
        String gender = "F";
        String password = "password";
        UserDetailsDataModel userDetailsDataModel = new UserDetailsDataModel(username, name, roles, email, contactNumber, dob, gender, password);
        when(myObjectUnderTest.UDDM.GetLoginStatus(anyString(),anyString())).thenReturn(userDetailsDataModel);

        myObjectUnderTest.onCreate(mockBundle);

        // Assert success
        Assert.assertEquals(myObjectUnderTest.UDDM.GetLoginStatus("test@abc.com", "password"), userDetailsDataModel);
    }

    @Test
    public void login_isNotSuccessful() {
        // Create Mocks
        MainActivity myObjectUnderTest = mock(MainActivity.class);
        UserDetailsDataManager udom = mock(UserDetailsDataManager.class);
        myObjectUnderTest.UDDM = udom;

        when(myObjectUnderTest.UDDM.GetLoginStatus(anyString(),anyString())).thenReturn(null);

        myObjectUnderTest.onCreate(mockBundle);

        // Assert failed login
        Assert.assertNull(myObjectUnderTest.UDDM.GetLoginStatus("test@abc.com", "password"));
    }
}
