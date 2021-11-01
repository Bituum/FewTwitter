import './feed.css'
import FeedHeader from './feed-header/feed-header';
import React from 'react';
import FeedNavbar from './feed-navbar/feed-navbar';
import FeedMain from './feed-main/feed-main';



const Feed = () => {
    return (
        <div className="feed">
            <FeedHeader/>
            <FeedNavbar/>
            <FeedMain/>
        </div>
    );
}

export default Feed;