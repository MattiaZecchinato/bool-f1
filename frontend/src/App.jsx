import { BrowserRouter, Route, Routes } from "react-router-dom"

//pages
import DriversPage from "./pages/DriversPage"
import NotFoundPage from "./pages/NotFoundPage"
import DriverDetailsPage from "./pages/DriverDetailsPage"

function App() {

  return (
    <>
      <BrowserRouter>
        <Routes>
          {/* <Route element={<MainLayout />}> */}
          {/* <Route path="/" element={<HomePage />} /> */}
          <Route path="/drivers" element={<DriversPage />} />
          <Route path="/drivers/:id" element={<DriverDetailsPage />} />
          {/* <Route path="/teams" element={<TeamsPage />} /> */}
          {/* <Route path="/teams/:id" element={<TeamDetailsPage />} /> */}
          <Route path="*" element={<NotFoundPage />} />
          {/* </Route> */}
        </Routes>
      </BrowserRouter>
    </>
  )
}

export default App