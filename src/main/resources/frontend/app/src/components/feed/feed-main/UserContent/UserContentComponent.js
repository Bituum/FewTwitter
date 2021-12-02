import React from "react";
import "./UserContent.css";

const UserContentComponent = (props) => {
    return (
        <div className="userContent">
            <div className="metainf">
                <h1>Пользователь: <span id="currentUser">{props.username}</span></h1>
            </div>
            <div className="commentSection">
                <h3>
                    <a href="#">комментарии</a>
                </h3>
            </div>
            <div className="commentContent">
                <h1>{props.commentContent}</h1>
            </div>
            <form>
                <div className="writeComment">
                    <input type="text"/>
                    <input type="file"/>
                    <button>Отправить</button>
                </div>
            </form>
        </div>
    );
}

export default UserContentComponent;

