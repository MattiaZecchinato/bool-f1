import { BrowserRouter, Route, Routes } from 'react-router-dom'
import { useState } from 'react'

// contexts
import LoaderContext from './contexts/LoaderContext'

// pages
import DriversPage from './pages/DriversPage'
import NotFoundPage from './pages/NotFoundPage'
import DriverDetailsPage from './pages/DriverDetailsPage'
import TeamsPage from './pages/TeamsPage'
import TeamDetailsPage from './pages/TeamDetailsPage'
import HomePage from './pages/HomePage'

// layouts
import MainLayout from './layouts/MainLayout'

function App() {

  const [isLoading, setIsLoading] = useState(false)

  return (
    <>
      <LoaderContext.Provider value={{ isLoading, setIsLoading }}>
        <BrowserRouter>
          <Routes>
            <Route element={<MainLayout />}>
              <Route path="/" element={<HomePage />} />
              <Route path="/drivers" element={<DriversPage />} />
              <Route path="/drivers/:id" element={<DriverDetailsPage />} />
              <Route path="/teams" element={<TeamsPage />} />
              <Route path="/teams/:id" element={<TeamDetailsPage />} />
              <Route path="*" element={<NotFoundPage />} />
            </Route>
          </Routes>
        </BrowserRouter>
      </LoaderContext.Provider>
    </>
  )
}

export default App