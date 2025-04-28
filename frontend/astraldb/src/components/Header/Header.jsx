import React from 'react';
import { 
  navbarStyle, 
  brandStyle, 
  linkStyle,
  linkHoverStyle,
  navLinksStyle,
  loginButtonStyle,
  loginButtonHoverStyle
} from './headerStyle'; // Make sure your headerStyle.js has all styles exported correctly

const Header = () => {
  // Helper functions for hover effect
  const handleLinkHover = (e) => {
    e.target.style.color = linkHoverStyle.color;
  };

  const handleLinkOut = (e) => {
    e.target.style.color = linkStyle.color;
  };

  const handleButtonHover = (e) => {
    e.target.style.backgroundColor = loginButtonHoverStyle.backgroundColor;
  };

  const handleButtonOut = (e) => {
    e.target.style.backgroundColor = loginButtonStyle.backgroundColor;
  };

  return (
    <nav style={navbarStyle}>
      <div style={brandStyle}>
        <a 
          href="/" 
          style={linkStyle} 
          onMouseOver={handleLinkHover} 
          onMouseOut={handleLinkOut}
        >
          ASTRAL DB
        </a>
      </div>

      <div style={navLinksStyle}>
        <a href="tracker" style={linkStyle} onMouseOver={handleLinkHover} onMouseOut={handleLinkOut}>Tracker</a>
        <a href="global-stats" style={linkStyle} onMouseOver={handleLinkHover} onMouseOut={handleLinkOut}>Global Stats</a>
        <a href="tier-list" style={linkStyle} onMouseOver={handleLinkHover} onMouseOut={handleLinkOut}>Tier List</a>
        <a href="items-database" style={linkStyle} onMouseOver={handleLinkHover} onMouseOut={handleLinkOut}>Items Database</a>
        <a href="import" style={linkStyle} onMouseOver={handleLinkHover} onMouseOut={handleLinkOut}>Import</a>
      </div>

      <button
        style={loginButtonStyle}
        onMouseOver={handleButtonHover}
        onMouseOut={handleButtonOut}
      >
        Login
      </button>
    </nav>
  );
};

export default Header;
