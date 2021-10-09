import './app.css'
import React from 'react';
import RegistrationHeader from '../registration/app-registration-header/app-registration-header';
import ChoiceWindow from '../registration/choice-window/choice-window';






function App() {
  return (
    <div className="App">
        <RegistrationHeader/>
        <ChoiceWindow/>
    </div>
  );
}

export default App;
