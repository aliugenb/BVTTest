package com.xmly.cases.find;

import com.xmly.cases.BaseCase;
import com.xmly.pages.find.FindIndexPage;
import org.testng.annotations.Test;

/**
 * Created with IntelliJ IDEA.
 * Author: ye.liu
 * Date: 2018/11/26
 * Time: 8:33 PM
 */
public class EnterFind extends BaseCase {

    @Test
    public static void enterFindHomePage() {
        FindIndexPage findIndexPage = new FindIndexPage(driver);
    }
}
