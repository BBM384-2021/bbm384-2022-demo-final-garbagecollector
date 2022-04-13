package app.service;

import app.model.User;

public interface UserService {
    User getById(Long userId);
}
