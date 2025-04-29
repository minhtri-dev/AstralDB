import { StrictMode } from 'react'
import { createRoot } from 'react-dom/client'
import './index.css'

import * as Pages from './pages'
import { Route, Routes, BrowserRouter } from 'react-router'
import { Footer, NavBar } from './components'
import Background from './components/Background/Background'

function App() {
  return (
    <>
      <BrowserRouter>
        <Background />
        <NavBar />
        <Routes>
          <Route path="/" element={<Pages.Home />} />
          <Route path="/tracker" element={<Pages.WarpTracker />} />
          <Route path="/login" element={<Pages.Login />} />
          <Route path="/import" element={<Pages.Import />} />
        </Routes>
        <Footer />
      </BrowserRouter>
    </>

  )
}

createRoot(document.getElementById('root')!).render(
  <StrictMode>
    <App />
  </StrictMode>,
)
