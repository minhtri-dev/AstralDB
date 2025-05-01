import { useNavigate } from 'react-router';
import { Icon } from '@iconify-icon/react';

const Header = () => {
  const navigate = useNavigate();

  const handleLoginClick = () => {
    navigate('/login');
  };

  return (
    <nav className="sticky top-0 z-50 bg-[#1c2029b0] backdrop-blur-md text-white font-semibold px-4 py-4 flex justify-between items-center border-b border-[#77787B]">
      <div>
        
        <a href="tracker" className="flex items-center gap-2">
          <Icon icon="solar:moon-bold-duotone" height={20} />ASTRAL DB
        </a>
      </div>

      <div className="flex gap-8">
        <a href="tracker" className="flex items-center gap-2">
          <Icon icon="famicons:ticket-outline" height={20} />Tracker
        </a>
        <a href="global-stats" className="flex items-center gap-2">
          <Icon icon="material-symbols:globe" height={20} />Global Stats
        </a>
        <a href="items-database" className="flex items-center gap-2">
          <Icon icon="hugeicons:database" height={20} />Items Database
        </a>
        <a href="import" className="flex items-center gap-2">
          <Icon icon="uil:import" height={20} />Import
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
