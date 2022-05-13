import {React, useState, useEffect} from "react";
import {useParams} from "react-router-dom";
import UserActivity from "../UserActivity/UserActivity";
import { makeStyles } from '@material-ui/core/styles';
import {DeleteWithAuth, GetWithAuth, PostWithoutAuth} from "../../services/HttpService";
import Text from "../Text/Text";
import Follow from "../Follow/Follow";
import { Link } from "react-router-dom";
import { Card, CardHeader, Avatar, CardContent } from "@mui/material";
import { Snackbar } from "@mui/material";
import { Typography } from "@mui/material";
import { OutlinedInput } from "@mui/material";
import { InputAdornment } from "@mui/material";
import { Button } from "@mui/material";
import SendIcon from '@mui/icons-material/Send';
import FormGroup from '@mui/material/FormGroup';
import FormControlLabel from '@mui/material/FormControlLabel';
import Switch from '@mui/material/Switch';

const useStyles = makeStyles((theme) => ({
    root: {
        width: 800,
        textAlign : "left",
        margin : 20
    },
    media: {
        height: 0,
        paddingTop: '56.25%', // 16:9
    },
    expand: {
        transform: 'rotate(0deg)',
        marginLeft: 'auto',
        transition: theme.transitions.create('transform', {
            duration: theme.transitions.duration.shortest,
        }),
    },
    avatar: {
        background: 'linear-gradient(45deg, #2196F3 30%, #21CBF3 90%)',
    },
    link: {
        textDecoration : "none",
        boxShadow : "none",
        color : "white"
    }
}));


function Email() {
    const classes = useStyles();
    const { userId} = useParams();
    const [user, setUser] = useState();
    const [text, setText] = useState("");
    const [title, setTitle] = useState("");
    const [reciever, setReciever] = useState("");
    const [isMass, setIsMass] = useState(false);
    const [isSent, setIsSent] = useState(false);


    const getUser = () => {
        GetWithAuth("http://localhost:8080/users/"+userId)
            .then(res => res.json())
            .then(
                (result) => {
                    setUser(result);
                    console.log("Result: " + result);
                },
                (error) => {
                    console.log(error)
                }
            )
    }

    const sendEmail = () => {}

    const handleChange = (event) => {
        if(!isMass){
            setIsMass(true);
        }else {
            setIsMass(false);
        }
        console.log(isMass);
    };

    const handleSubmit = () => {}

    const handleTitle = (value) => {}

    const handleText = (value) => {}

    const handleClose = (event, reason) => {
        if (reason === 'clickaway') {
            return;
        }
        setIsSent(false);
    };

    return (
        <div>
            <Snackbar open={isSent} autoHideDuration={1200} onClose={handleClose}>

            </Snackbar>
            <Card className={classes.root}>
                <CardHeader
                    title={<OutlinedInput
                        id="outlined-adornment-amount"
                        multiline
                        placeholder="To: "
                        inputProps={{ maxLength: 25 }}
                        fullWidth
                        value={reciever}
                        onChange={(i) => handleTitle(i.target.value)}
                    >
                    </OutlinedInput>}
                />
                <CardContent>
                    <Typography variant="body2" color="textSecondary" component="p">
                        <OutlinedInput
                            id="outlined-adornment-amount"
                            multiline
                            placeholder="Title"
                            inputProps={{ maxLength: 250 }}
                            fullWidth
                            value={title}
                            onChange={(i) => handleText(i.target.value)}

                        >
                        </OutlinedInput>

                        <OutlinedInput
                            id="outlined-adornment-amount"
                            multiline
                            placeholder="Mail"
                            inputProps={{ maxLength: 250 }}
                            fullWidth
                            value={text}
                            onChange={(i) => handleText(i.target.value)}
                        >
                        </OutlinedInput>

                        <div>
                            {localStorage.getItem("userType") != "student" ?
                            <FormControlLabel control={ <Switch
                                checked={isMass}
                                onChange={handleChange}
                                inputProps={{ 'aria-label': 'controlled' }}
                            />} labelPlacement="start" label="Mass Mail" />
                            : ""
                            }
                        </div>

                        <Button
                            variant="contained"
                            style={{
                                background: 'linear-gradient(45deg, #2196F3 30%, #21CBF3 90%)',
                                color: 'white'
                            }}
                            onClick={handleSubmit}
                        >Send<SendIcon></SendIcon></Button>

                    </Typography>
                </CardContent>
            </Card>
        </div>
    )
}

export default Email;