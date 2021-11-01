import React from "react";
import './feed-navbar.css';
import AddNewPost from "../feed-addNewPost/feedAddNewPost";


const FeedNavbar = () => {
    return (
        <div className="navbarContainer">
            <div className="navbarList">
                <nav className=''>
                    <ul className=''>
                        <li className=''>
                            <a href="/#">Лента</a>
                        </li>
                        <li className=''>
                            <a href="/#">Еще что-то</a>
                        </li>
                        <li>
                            <AddNewPost/>
                        </li>
                    </ul>
                </nav>
            </div>
        </div>
    );
}

export default FeedNavbar;