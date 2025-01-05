package com.project.IndiaCenter.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class DefaultFormController {

    @GetMapping("/")
    @ResponseBody
    public String showForm() {
        return """
               <html>
               <head>
                   <title>Signup or Signin</title>
               </head>
               <body>
                   <h2>Signup or Signin</h2>
                   <<form method="post" action="/signup" >
                          
                       <label for="email">
                       Email:
                       </label><br>
                       <input type="text" id="email" name="email" required><br><br>
                       
                       <label for="password">Password:</label><br>
                       <input type="password" id="password" name="password" required><br><br>
                       
                       <button type="submit">Sign Up</button>
                   </form>
                   <br>
                   <<form method="post" action="/signin">
                                                            
                       <label for="email">Email:</label><br>
                       <input type="text" id="email" name="email" required><br><br>
                       
                       <label for="password">Password:</label><br>
                       <input type="password" id="password" name="password" required><br><br>
                       
                       <button type="submit">Sign In</button>
                   </form>
               </body>
               </html>
               """;
    }
}
