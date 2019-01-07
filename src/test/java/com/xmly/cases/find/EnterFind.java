package com.xmly.cases.find;

import com.xmly.cases.AndroidBaseCase;
import com.xmly.pages.find.FindIndexPage;
import org.testng.annotations.Test;

/**
 * Created with IntelliJ IDEA.
 * Author: ye.liu
 * Date: 2018/11/26
 * Time: 8:33 PM
 */
public class EnterFind extends AndroidBaseCase {

    @Test
    public static void enterFindHomePage() {
        FindIndexPage findIndexPage = new FindIndexPage(driver);
    }
}
