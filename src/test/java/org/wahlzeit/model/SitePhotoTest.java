package org.wahlzeit.model;

import org.junit.Before;
import org.junit.ClassRule;
import org.junit.Test;
import org.junit.rules.RuleChain;
import org.wahlzeit.testEnvironmentProvider.*;

import static org.junit.Assert.*;

public class SitePhotoTest {
    private SitePhoto photo;

    @ClassRule
    public static RuleChain ruleChain = RuleChain.
            outerRule(new LocalDatastoreServiceTestConfigProvider()).
            around(new RegisteredOfyEnvironmentProvider()).
            around(new SysConfigProvider()).
            around(new UserServiceProvider()).
            around(new UserSessionProvider());

    @Before
    public void initPhoto() {
        photo = new SitePhoto();
    }

    @Test
    public void defaultPhotoShouldHaveNoAssociatedContinent() {
        assertEquals(photo.getSite().getContinent(), Site.Continent.Unknown);
    }

    @Test(expected = IllegalArgumentException.class)
    public void setSiteWithInvalidEnumShouldThrowException() {
        photo.setSite(null);
    }

}