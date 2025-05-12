import React, { useState } from 'react';
import { confirmSignUp } from 'aws-amplify/auth';
import LogoffButton from 'components/LogoffButton';

const Home = () => {
  const [username, setUsername] = useState('');
  const [confirmationCode, setConfirmationCode] = useState('');
  const [error, setError] = useState<string | null>(null);

  const handleSubmit = async (e: React.FormEvent) => {
    e.preventDefault();
    setError(null);

    try {
      await confirmSignUp({ username, confirmationCode });
      alert('Successfully confirmed!');
    } catch (err: any) {
      console.error('Confirmation error:', err);
      setError(err.message || 'Something went wrong');
    }
  };

  return (
    <form onSubmit={handleSubmit}>
      <h2>Confirm Your Account</h2>
      <div>
        <label>Username or Email</label>
        <input value={username} onChange={(e) => setUsername(e.target.value)} required />
      </div>
      <div>
        <label>Confirmation Code</label>
        <input value={confirmationCode} onChange={(e) => setConfirmationCode(e.target.value)} required />
      </div>
      <button type="submit">Confirm</button>
      {error && <p style={{ color: 'red' }}>{error}</p>}
    </form>
  );
};

export default Home