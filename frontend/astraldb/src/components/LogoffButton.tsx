import { signOut } from 'aws-amplify/auth';
import { useNavigate } from 'react-router';

const LogoffButton = () => {
  const navigate = useNavigate();

  const handleLogoff = async () => {
    try {
      await signOut();
      alert('You have been logged out.');
      // Redirect to login page (or wherever you'd like after logoff)
      navigate('/login');
    } catch (error) {
      console.error('Error logging out:', error);
      alert('An error occurred while logging out');
    }
  };

  return <button onClick={handleLogoff}>Log Off</button>;
};

export default LogoffButton;
