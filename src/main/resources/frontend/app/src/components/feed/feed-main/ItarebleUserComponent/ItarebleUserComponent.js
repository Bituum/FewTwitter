import React from "react";
import UserContentComponent from "../UserContent/UserContentComponent";
import "./IterableUserComponent.css";

const ItarebleUserComponent = (props) => {
    return (
        <div className="secondFeed" key={props.user.id}>
            <div
                className="secondFeedIteration">{props.user.userPostList.length > 0 ? props.user.userPostList.map((post) => {
                {
                    return (
                        <div className="content">
                            <UserContentComponent
                                username={props.user.login}
                                commentContent={post.commentSection}/>
                        </div>
                    );
                }
            }) : null}</div>
        </div>
    );
}

export default ItarebleUserComponent;