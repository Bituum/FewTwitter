import React from "react";

const UserContentComponent = (props) => {
    return (
        <div className="userContent">
            <div className="metainf">
                <h1>{props.username}</h1>
            </div>
            <div className="commentContent">
                <h1>{props.commentContent}</h1>
            </div>
        </div>
    );
}

export default UserContentComponent;

