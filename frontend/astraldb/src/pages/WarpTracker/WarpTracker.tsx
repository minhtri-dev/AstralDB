import { Sidebar, WarpList, WarpStats } from './components';

const WarpTracker = () => {
  return (
    <div>
      <div className="d-flex">
        <div className="sidebar">
          <Sidebar />
        </div>
        <div className="main-content flex-grow-1">
          <WarpStats />
          <WarpList />
        </div>
      </div>
    </div>
  )
}

export default WarpTracker