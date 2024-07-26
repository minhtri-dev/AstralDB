import React from 'react';

const Header = () => {
  return (
    <nav className="bg-gray-900 text-white px-4 py-3 flex items-center justify-between">
      <div className="text-xl font-semibold">
        <a href="#home" className="hover:text-gray-400">ASTRAL DB</a>
      </div>
      <div className="flex space-x-10">
        <a href="#tracker" className="font-semibold hover:text-gray-400">Tracker</a>
        <a href="#global-stats" className="font-semibold hover:text-gray-400">Global Stats</a>
        <a href="#tier-list" className="font-semibold hover:text-gray-400">Tier List</a>
        <a href="#items-database" className="font-semibold hover:text-gray-400">Items Database</a>
        <a href="#import" className="font-semibold hover:text-gray-400">Import</a>
      </div>
      <button className="bg-login font-semibold text-white px-6 py-1 rounded-full hover:bg-login-hover">
        Login
      </button>
    </nav>
  );
};

export default Header;
