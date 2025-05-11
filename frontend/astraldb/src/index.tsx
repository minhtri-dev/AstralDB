import { StrictMode } from 'react'
import { createRoot } from 'react-dom/client'
import { Route, Routes, BrowserRouter } from 'react-router'

import './index.css'
import * as Pages from './pages'
import { Footer, NavBar, Background } from '@components'
import '@config/amplifyConfig'; 

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
          <Route path="/register" element={<Pages.Register />} />
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
