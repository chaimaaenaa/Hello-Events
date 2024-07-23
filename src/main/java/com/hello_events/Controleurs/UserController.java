package com.hello_events.Controleurs;

import com.hello_events.Entites.User;
import com.hello_events.Security.JwtAuth;
import com.hello_events.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private JwtAuth jwtAuth;
    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody User user) {
        return ResponseEntity.ok(userService.registerUser(user));
    }

    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody User user) {
        User foundUser = userService.findByUsername(user.getUsername());
        if (foundUser != null && new BCryptPasswordEncoder().matches(user.getPassword(), foundUser.getPassword())) {
            List<String> roles = Collections.singletonList(foundUser.getRole().name());
            String token = jwtAuth.generateToken(foundUser.getUsername(), roles);
            return ResponseEntity.ok(token);
        }
        return ResponseEntity.status(401).body("Invalid username or password");
    }

    @GetMapping("/{username}")
    public ResponseEntity<?> getUser(@PathVariable String username) {
        return ResponseEntity.ok(userService.findByUsername(username));
    }

    @PutMapping("/update")
    public ResponseEntity<?> updateUser(@RequestBody User user) {
        User updatedUser = userService.updateUser(user);
        if (updatedUser != null) {
            return ResponseEntity.ok(updatedUser);
        }
        return ResponseEntity.status(404).body("User not found");
    }
}
