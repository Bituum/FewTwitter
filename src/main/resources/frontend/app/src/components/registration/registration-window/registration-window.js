import './registration-window.css'

const RegistrationWindow = () => {
    return (
        <div className="login-flex">
            <div className="login-container">

                <div className="authLine">
                    <div className="authContent">
                        <p>ENTER NEW LOGIN</p>
                        <input type="text" />
                    </div>
                    <div className="authContent">
                        <p>ENTER PASSWORD</p>
                        <input type="password" />
                    </div>
                    </div>
                    <button type="submit" className='srbtn'>CONTINUE</button>           
            </div>
        </div>
    );
}

export default RegistrationWindow;