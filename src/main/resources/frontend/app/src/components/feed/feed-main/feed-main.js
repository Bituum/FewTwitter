import React from "react";
import './feed-main.css';
import ModalWindow from "./main-feed-modal-component/modal-window";

const FeedMain = () => {
    return (
        <div className='mainFeed'>
            <ModalWindow/>
            <ModalWindow/>
            <ModalWindow/>
        </div>
    );
}

export default FeedMain;