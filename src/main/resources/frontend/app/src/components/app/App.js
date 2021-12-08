import './app.css'
import React from 'react';
import RegistrationHeader from '../registration/app-registration-header/app-registration-header';
import ChoiceWindow from '../registration/choice-window/choice-window';
import Content from "../registration/content/Content";
import FooterReg from "../registration/footer/FooterReg";






function App() {
  return (
    <div className="App">
        <RegistrationHeader/>
        <Content/>
        <ChoiceWindow/>
        <FooterReg/>
    </div>
  );
}

export default App;
