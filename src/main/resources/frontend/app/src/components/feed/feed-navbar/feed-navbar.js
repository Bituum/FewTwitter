import React from "react";
import './feed-navbar.css';


const FeedNavbar = () => {
    return (
        <div className="navbarContainer">
            <div className="navbarList">
                <nav className=''>
                    <ul className=''>
                        <li className=''>
                            <a href="#">Лента</a>
                        </li>
                        <li className=''>
                            <a href="#">Личный кабинет</a>
                        </li>
                        <li className=''>
                            <a href="#">Еще что-то</a>
                        </li>
                    </ul>
                </nav>
            </div>
        </div>
    );
}

export default FeedNavbar;