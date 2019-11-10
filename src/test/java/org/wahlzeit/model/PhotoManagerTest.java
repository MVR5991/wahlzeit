package org.wahlzeit.model;

import org.junit.ClassRule;
import org.junit.Test;
import org.junit.rules.RuleChain;
import org.wahlzeit.testEnvironmentProvider.*;

import static org.junit.Assert.*;

public class PhotoManagerTest {

    @ClassRule
    public static RuleChain ruleChain = RuleChain.
            outerRule(new LocalDatastoreServiceTestConfigProvider()).
            around(new RegisteredOfyEnvironmentProvider()).
            around(new SysConfigProvider()).
            around(new UserServiceProvider()).
            around(new UserSessionProvider());

    @Test
    public void testCorrectInstance() {
        assertTrue(PhotoManager.instance instanceof SitePhotoManager);
    }

}