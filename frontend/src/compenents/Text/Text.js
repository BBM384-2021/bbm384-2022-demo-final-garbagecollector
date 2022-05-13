import * as React from 'react';
import Box from '@mui/material/Box';
import TextField from '@mui/material/TextField';
import { makeStyles } from '@material-ui/core/styles'
import {Button, InputAdornment, OutlinedInput, Typography} from "@mui/material";
import {useState} from "react";
import {PutWithAuth, RefreshToken} from "../../services/HttpService";

const useStyles = makeStyles({
    container: {
        display: "flex",
        flexWrap: "wrap",
        justifyContent : "center",
        alignItems : "center",
        backgroundColor: '#ffffff',
    },
    textStyle: {
        width: '55ch',
    }
})

export default function Text(props) {
    const classes = useStyles();
    const {userName, userEmail, userId} = props;
    const [isSent, setIsSent] = useState(false);
    const [newName, setNewName] = useState(null);
    const [newEmail, setNewEmail] = useState(null);
    const [newPassword, setNewPassword] = useState(null);

    // Save tuşuna baıldığında verilen parametreye göre update fonksiyonunu çağır.
    const saveChanges = () => {
        PutWithAuth("http://localhost:8080/users/"+userId,{
            userName: newName,
            password : newPassword,
            email : newEmail,
            avatar: -1
        }).then((result) => {
            console.log(result)}
            )
            .catch((err) => {
                console.log(err)
            })
    }

    const handleChanges = () => {
        saveChanges();
        setIsSent(true);
        setNewName(null);
        setNewEmail(null);
    }

    const handleName = (value) => {
        setNewName(value);
        setIsSent(false);
    }

    const handleEmail = (value) => {
        setNewEmail(value);
        setIsSent(false);
    }

    const handlePassword = (value) => {
        setNewPassword(value);
        setIsSent(false);
    }

    return (
            <div className={classes.container}>
                <Typography variant="body2" color="textSecondary" component="p" className={classes.textStyle}>
                    <OutlinedInput
                        id="outlined-adornment-amount"
                        placeholder={userName}
                        inputProps={{ maxLength: 25 }}
                        fullWidth
                        value={newName}
                        onChange={(i) => handleName(i.target.value)}
                        endAdornment={
                            <InputAdornment position="end">
                                <Button
                                    variant="contained"
                                    style={{
                                        background: '#8c9eff',
                                        color: 'white'
                                    }}
                                    onClick={handleChanges}
                                >Save</Button>
                            </InputAdornment>
                        }
                    >
                    </OutlinedInput>

                    <OutlinedInput
                        id="outlined-adornment-amount"
                        placeholder={userEmail}
                        inputProps={{ maxLength: 25 }}
                        fullWidth
                        value={newEmail}
                        onChange={(i) => handleEmail(i.target.value)}
                        endAdornment={
                            <InputAdornment position="end">
                                <Button
                                    variant="contained"
                                    style={{
                                        background: '#80d8ff',
                                        color: 'white'
                                    }}
                                    onClick={handleChanges}
                                >Save</Button>
                            </InputAdornment>
                        }
                    >
                    </OutlinedInput>

                    <OutlinedInput
                        id="outlined-adornment-amount"
                        placeholder="Your Password: *****"
                        inputProps={{ maxLength: 25 }}
                        fullWidth
                        value={newPassword}
                        onChange={(i) => handlePassword(i.target.value)}
                        endAdornment={
                            <InputAdornment position="end">
                                <Button
                                    variant="contained"
                                    style={{
                                        background: '#ffd180',
                                        color: 'white'
                                    }}
                                    onClick={handleChanges}
                                >Save</Button>
                            </InputAdornment>
                        }
                    >
                    </OutlinedInput>
                    In order to see the changes please reload the page.
                </Typography>
            </div>
    );
}

/*
*
*  <Box
            className={classes.container}
            component="form"
            sx={{
                '& > :not(style)': { m: 1, width: '25ch' },
            }}
            noValidate
            autoComplete="off"
        >
                <TextField className={classes.textStyle} id="outlined-basic" defaultValue={userName} label="User Name" variant="outlined" />
                <TextField className={classes.textStyle} id="outlined-basic" defaultValue={userName} label="User E-Mail" variant="outlined" />
                <TextField className={classes.textStyle} id="outlined-basic" defaultValue="*****" label="User Password" variant="outlined" />
             </Box>
* */