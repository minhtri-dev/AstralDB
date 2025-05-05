import { useNavigate } from 'react-router';
import { Icon } from '@iconify-icon/react';

const Header = () => {
  const navigate = useNavigate();

  const handleLoginClick = () => {
    navigate('/login');
  };

  return (
    <nav className="sticky top-0 z-50 bg-[#1c2029b0] backdrop-blur-md text-white font-semibold px-4 py-4 flex justify-between items-center border-b border-[#37383a]">
      <div>
        
        <a href="tracker" className="flex items-center gap-1">
          <Icon icon="solar:moon-bold-duotone" height={20} />
          ASTRAL DB
        </a>
      </div>

      <div className="flex gap-8">
        <a href="tracker" className="flex items-center gap-2">
          <Icon icon="famicons:ticket-outline" height={20} />
          <span className="hidden md:inline">Tracker</span>
        </a>
        <a href="global-stats" className="flex items-center gap-2">
          <Icon icon="material-symbols:globe" height={20} />
          <span className="hidden md:inline">Global Stats</span>
        </a>
        <a href="items-database" className="flex items-center gap-2">
          <Icon icon="hugeicons:database" height={20} />
          <span className="hidden md:inline">Items Database</span>
        </a>
        <a href="import" className="flex items-center gap-2">
          <Icon icon="uil:import" height={20} />
          <span className="hidden md:inline">Import</span>
        </a>
      </div>

      <button
        className="flex items-center gap-2 bg-[#00ADC9] hover:bg-[#0085A0] text-white font-semibold px-6 py-1 rounded-full transition-colors duration-300 ease-in-out"
        onClick={handleLoginClick}
      >
        <Icon icon="line-md:login" height={20} />Login
      </button>
    </nav>
  );
};

export default Header;
