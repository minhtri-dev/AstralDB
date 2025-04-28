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
        <Route path="/" element={<Pages.Home />} />
        <Route path="/tracker" element={<Pages.WarpTracker />} />
        <Route path="/login" element={<Pages.Login />} />
        <Route path="/import" element={<Pages.Import />} />
      </Routes>
      <Footer />
      </BrowserRouter>

  );
}

export default App;
