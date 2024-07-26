// import logo from './logo.svg';
import './App.css';
import Header from './components/layouts/Header';
import Footer from './components/layouts/Footer';
import WarpTrackerPage from './components/pages/WarpTracker/WarpTrackerPage';

function App() {
  return (
    <div>
      <Header />
      <WarpTrackerPage />
      <Footer />
    </div>
  );
}

export default App;
