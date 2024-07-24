package com.hello_events.Controleurs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.hello_events.Entites.Contact;
import com.hello_events.Services.ContactService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/contacts")
public class ContactController {

    @Autowired
    private ContactService contactService;

    @PostMapping
    public Contact createContact(@RequestParam String name, @RequestParam String email, @RequestParam String subject, @RequestParam String message) {
        return contactService.saveContact(name, email, subject, message);
    }

    @GetMapping
    public List<Contact> getAllContacts() {
        return contactService.getAllContacts();
    }

    @GetMapping("/{id}")
    public Optional<Contact> getContactById(@PathVariable Long id) {
        return contactService.getContactById(id);
    }

    @PutMapping("/{id}/status")
    public Contact updateContactStatus(@PathVariable Long id, @RequestParam Contact.ContactStatus status) {
        return contactService.updateContactStatus(id, status);
    }

    @DeleteMapping("/{id}")
    public void deleteContact(@PathVariable Long id) {
        contactService.deleteContact(id);
    }
}
