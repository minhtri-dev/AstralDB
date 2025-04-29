
import { useNavigate } from 'react-router';
  
  const Header = () => {
    const navigate = useNavigate() 

    const handleLoginClick = () => {
      navigate('/login'); 
    }
  
    return (
      <nav className='bg-[#282828] text-white font-semibold px-4 py-3 flex justify-between items-center opacity-95 border-b border-[#77787B]'>
        <div>
          <a href="/"> ASTRAL DB </a>
        </div>
  
        <div className='flex gap-10'>
          <a href="tracker">Tracker</a>
          <a href="global-stats">Global Stats</a>
          <a href="tier-list">Tier List</a>
          <a href="items-database">Items Database</a>
          <a href="import">Import</a>
        </div>
  
        <button className="bg-[#00ADC9] hover:bg-[#0085A0] text-white font-semibold px-6 py-1 rounded-full transition-colors duration-300 ease-in-out" onClick={handleLoginClick}>Login</button>
      </nav>
    );
  };
  
  export default Header;