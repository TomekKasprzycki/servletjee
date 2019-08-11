package pl.coderslab.Cookies;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

public class CookieUtil {

    static String retriveCookie(Cookie[] cookies, String name) {
        for (Cookie c : cookies) {
            if (name.equals(c.getName())) {
                return c.getValue();
            }
        }
        return "";
    }

    static void deleteCookie(Cookie[] cookies, String name, HttpServletResponse response) {
        for (Cookie c : cookies) {
            if (name.equals(c.getName())) {
                c.setMaxAge(0);
                response.addCookie(c);
            }
        }
    }
}
