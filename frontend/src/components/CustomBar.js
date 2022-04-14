import React, {useEffect} from 'react';
import AppBar from '@mui/material/AppBar';
import Box from '@mui/material/Box';
import Toolbar from '@mui/material/Toolbar';
import Typography from '@mui/material/Typography';
import Button from '@mui/material/Button';
import IconButton from '@mui/material/IconButton';
import MenuIcon from '@mui/icons-material/Menu';
import { ThemeProvider, createTheme } from '@mui/material/styles';
import { useNavigate} from 'react-router-dom';
import MenuItem from '@mui/material/MenuItem';
import Menu from '@mui/material/Menu';

// passing in function to flip confirm authorization and the variable that defines it
export default function ButtonAppBar({Authorized, auth}) {
  const darkTheme = createTheme({
    palette: {
      mode: 'light',
      primary: {
        main: '#1976d2',
      },
    },
  });

  const [log, setLog] = React.useState("Login");

  // login button switch
  useEffect(() => {
    if(auth){
      setLog('Log-out');
    }
    if(!auth){
      setLog('Login');
    }
  })

  let navigate = useNavigate();

  const [anchorEl, setAnchorEl] = React.useState(null);
  const open = Boolean(anchorEl);
  const handleClick = (event) => {
    setAnchorEl(event.currentTarget);
  };
  const handleClose = () => {
    setAnchorEl(null);
  };

  // implement a dropdown menu to log-out and to go back to registration
  
  return (
    <Box sx={{ flexGrow: 1 }}>
    <ThemeProvider theme={darkTheme}>

       <AppBar position="static">
        <Toolbar>



          <Typography variant="h6" component="div" sx={{ flexGrow: 1 }}>
            LinkedHU_CENG
          </Typography>
          
            {/* implement a log out that will drop the admin authorization */}
          <Button onClick={()=>{navigate("/Login"); Authorized(false)}} color="inherit">{log}</Button>
          
        </Toolbar>
      </AppBar> 
      </ThemeProvider>
    </Box>
  );
}
