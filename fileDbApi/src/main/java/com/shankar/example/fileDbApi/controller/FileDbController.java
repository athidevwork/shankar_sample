package com.shankar.example.fileDbApi.controller;

import com.shankar.example.fileDbApi.data.JdbcRepository;
import com.shankar.example.fileDbApi.model.User;
import com.shankar.example.fileDbApi.model.Users;
import com.shankar.example.fileDbApi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

@RestController
public class FileDbController {
    private static final String template = "Hello, %s!";
    //private final AtomicLong counter = new AtomicLong();
    private static Map<Integer, User> DB = new HashMap<>();
    //@Autowired
    //private UserService userService;
    @Autowired
    private JdbcRepository jdbcRepository;

    @GetMapping("/test")
    public String test () {
        return "Hello FileDbResource";
    }

    @GetMapping(value="/users", produces={MediaType.APPLICATION_JSON_VALUE,
            MediaType.APPLICATION_XML_VALUE})
    public Users getAllUsers() {
        Users users = new Users();
        users.setUsers(new ArrayList<>(DB.values()));
        return users;
    }

    @PostMapping(value="/guiusers", produces={MediaType.APPLICATION_JSON_VALUE,
            MediaType.APPLICATION_XML_VALUE})
    public Users getGuiUsers(@RequestParam("file") File file) throws IOException {
        System.out.println("File path = " + file.getPath()
        + ", name = " + file.getName());
        Users users = new Users();
        //users.setUsers(new ArrayList<>(readFromFileContents(file)));
        users.setUsers(new ArrayList<>(readFromFile("src/main/resources/guifile.dat")));
        return users;
    }

    private ArrayList<User>  readFromFileContents(File file) throws FileNotFoundException {
        Scanner sc = new Scanner(file);
        String line;
        ArrayList<User> users = new ArrayList<User>();
        while ((line = sc.nextLine()) != null) {
            System.out.println(line);
            String[] tokens = line.split(",");
            users.add(new User(tokens[0], tokens[1], tokens[2], tokens[3]));
        }
        sc.close();
        System.out.println("File Users size = " + users.size());
        return users;
    }

    @GetMapping(value="/fileusers", produces={MediaType.APPLICATION_JSON_VALUE,
            MediaType.APPLICATION_XML_VALUE})
    public Users getFileUsers() throws IOException {
        Users users = new Users();
        users.setUsers(new ArrayList<>(readFromFile("src/main/resources/file.dat")));
        return users;
    }

    private ArrayList<User> readFromFile(String file) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(file));
        String line;
        ArrayList<User> users = new ArrayList<User>();
        while ((line = br.readLine()) != null) {
            System.out.println(line);
            String[] tokens = line.split(",");
            users.add(new User(tokens[0], tokens[1], tokens[2], tokens[3]));
        }
        br.close();
        System.out.println("Users size = " + users.size());
       return users;
    }

    @GetMapping(value="/fileusers2DB", produces={MediaType.APPLICATION_JSON_VALUE,
            MediaType.APPLICATION_XML_VALUE})
    public Users getFileUsers2DB() throws IOException {
        Users users = new Users();
        users.setUsers(new ArrayList<>(readFromFile("src/main/resources/guifile.dat")));
        //write users to db - http://localhost:8086/h2-console, jdbc:h2:mem:testdb
        //users.getUsers().forEach(user -> userService.saveOrUpdate(user));
        users.getUsers().forEach(user -> jdbcRepository.insertUser(user.getId(), user.getFirstName(),
                                                                user.getLastName(), user.getUri()));
        return users;
    }

    /*@GetMapping("/greeting")
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
        return new Greeting(counter.incrementAndGet(), String.format(template, name));
    }*/

    static
    {
        System.out.print("Creating users");
        User user1 = new User();
        user1.setId(1);
        user1.setFirstName("John");
        user1.setLastName("Wick");
        user1.setUri("/user-management/1");

        User user2 = new User();
        user2.setId(2);
        user2.setFirstName("Harry");
        user2.setLastName("Potter");
        user2.setUri("/user-management/2");

        DB.put(user1.getId(), user1);
        DB.put(user2.getId(), user2);
    }
}
