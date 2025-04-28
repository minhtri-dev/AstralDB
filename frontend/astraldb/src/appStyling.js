// appstyling.js

export const ContentBackgroundStyle = {
  backgroundImage: 'linear-gradient(180deg, transparent, #282828 80%), url(/hsr-background.png)', // Updated gradient and image
  backgroundSize: 'cover', // Make sure the background covers the entire viewport
  backgroundPosition: 'center', // Center the background
  backgroundRepeat: 'no-repeat', 
  zIndex: -1,
  position: 'absolute', // Ensure it's positioned correctly behind other elements
  top: 0,
  width: '100%',
  height: '1000px'
};
