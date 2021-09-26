import './app.css'
import RegistrationHeader from '../registration/app-registration-header/app-registration-header';
import ChoiceWindow from '../registration/choice-window/choice-window';
import React from 'react';





function App() {
  return (
    <div className="App">
        <RegistrationHeader/>
        <ChoiceWindow/>
    </div>
  );
}

export default App;
