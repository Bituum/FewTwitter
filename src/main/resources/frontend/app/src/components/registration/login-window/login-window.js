

const LoginWindow = () => {
    return (
        <div className="login-container">
            <div>
                <p>ENTER LOGIN</p>
                <input type="text" />
                
            </div>
            <br/>
            <div>
                <p>ENTER PASSWORD</p>
                <input type="password" />
                <button type="submit" className='srbtn'>CONTINUE</button>
            </div>
        </div>
    );
}

export default LoginWindow;