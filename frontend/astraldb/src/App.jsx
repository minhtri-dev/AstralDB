import Footer from './components/Footer/Footer';
import Header from './components/Header/Header';
import { Route, Routes, BrowserRouter } from 'react-router-dom';
import * as Pages from './pages';
import { ContentBackgroundStyle } from './appStyling';


function App() {
  return (
      <BrowserRouter>
      <Header />
      <div style={ContentBackgroundStyle} /> 
      <Routes>
        <Route path="/" element={<Pages.WarpTracker />} />
      </Routes>
      <Footer />
      </BrowserRouter>

  );
}

export default App;
