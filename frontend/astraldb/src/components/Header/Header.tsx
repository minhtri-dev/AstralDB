import { 
  navbarStyle, 
  brandStyle, 
  linkStyle,
  linkHoverStyle,
  navLinksStyle,
  loginButtonStyle,
  loginButtonHoverStyle
} from './headerStyle'; 
import { useNavigate } from 'react-router-dom'; // <-- add this to handle navigation

const Header = () => {
  const navigate = useNavigate(); // <-- initialize navigate function

  // Helper functions for hover effect
  const handleLinkHover = (e: any) => {
    e.target.style.color = linkHoverStyle.color;
  };

  const handleLinkOut = (e: any) => {
    e.target.style.color = linkStyle.color;
  };

  const handleButtonHover = (e: any) => {
    e.target.style.backgroundColor = loginButtonHoverStyle.backgroundColor;
  };

  const handleButtonOut = (e: any) => {
    e.target.style.backgroundColor = loginButtonStyle.backgroundColor;
  };

  const handleLoginClick = () => {
    navigate('/login'); 
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
        onClick={handleLoginClick} 
      >
        Login
      </button>
    </nav>
  );
};

export default Header;
