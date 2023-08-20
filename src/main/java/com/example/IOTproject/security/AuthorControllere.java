package com.example.IOTproject.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthorControllere {
    @Autowired
    private TokenUtil tokenUtil;
    @Autowired
    private UserService userService;
    @Autowired
    private AuthenticationManager authenticationManager;
    @PostMapping(value = {"","/"})
    public JWTresponse signIn(@RequestBody SignInRequest signInRequest){
        final Authentication authentication=authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(signInRequest.getUserName(),signInRequest.getPassword())
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);
        UserDetails userDetails=userService.loadUserByUsername(signInRequest.getUserName());
        String token=tokenUtil.generateToken(userDetails);
        JWTresponse jwTresponse=new JWTresponse(token);
        return jwTresponse;
    }

}
