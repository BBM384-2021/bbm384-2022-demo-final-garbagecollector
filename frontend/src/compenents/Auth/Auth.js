import { FormControl, InputLabel, Input, Button, FormHelperText } from "@mui/material";
import React, { useState } from "react";
import { useHistory } from "react-router";
import { PostWithoutAuth } from "../../services/HttpService";
function Auth() {

    const [username, setUsername] = useState("")
    const [password, setPassword] = useState("")
    let history = useHistory();
    const handleUsername = (value) => {
        setUsername(value)
    }


    const handlePassword = (value) => {
        setPassword(value)
    }
    const requestOptions = {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
            "Accept": 'application/json'
        },
        body: JSON.stringify({
            userName: username,
            password: password,
            confirmPassword: password,
            email: "enesmankey@gmail.com",
            userType: "student"
        })
    };
    const sendRequest = (path) => {
        fetch('http://localhost:8080/auth/' + path, requestOptions)
            .then(response => response.json())
            .then(data => { console.log(data) 
                localStorage.setItem("tokenKey",data.accessToken);
                            localStorage.setItem("refreshKey",data.refreshToken);
                            localStorage.setItem("currentUser",data.id);
                            localStorage.setItem("userName",data.userName);
            });
    }

    const handleButton = (path) => {
        sendRequest(path);
        setUsername("")
        setPassword("")
        history.go("/auth")

    }

    return (
        <FormControl>
            <InputLabel>Username</InputLabel>
            <Input onChange={(i) => handleUsername(i.target.value)} />
            <InputLabel style={{ top: 80 }}>Password</InputLabel>
            <Input style={{ top: 40 }}
                onChange={(i) => handlePassword(i.target.value)} />
            <Button variant="contained"
                style={{
                    marginTop: 60,
                    background: 'linear-gradient(45deg, #2196F3 30%, #21CBF3 90%)',
                    color: 'white'
                }}
                onClick={() => handleButton("register")}>Register</Button>
            <FormHelperText style={{ margin: 20 }}>Are you already registered?</FormHelperText>
            <Button variant="contained"
                style={{
                    background: 'linear-gradient(45deg, #2196F3 30%, #21CBF3 90%)',
                    color: 'white'
                }}
                onClick={() => handleButton("login")}>Login</Button>

        </FormControl>
    )
}

export default Auth;