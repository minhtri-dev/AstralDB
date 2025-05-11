// LoginForm.tsx
import { Link } from 'react-router';
import React, { useState } from 'react';
import { signIn } from 'aws-amplify/auth';

const Login = () => {
  const [username, setUsername] = useState('');
  const [password, setPassword] = useState('');
  const [error, setError] = useState<string | null>(null);
  const [loading, setLoading] = useState(false);

  const handleLogin = async (e: React.FormEvent) => {
    e.preventDefault();
    setError(null);
    setLoading(true);

    try {
      const user = await signIn({ username, password });
      console.log('Signed in:', user);
      alert('Login successful!');
      // Optionally redirect or fetch session data
    } catch (err: any) {
      console.error('Login error:', err);
      setError(err.message || 'Login failed');
    } finally {
      setLoading(false);
    }
  };

  return (
    <form onSubmit={handleLogin} style={{ maxWidth: 400, margin: 'auto' }}>
      <h2 className="text-5xl">Login</h2>
      <div>
        <label>Username</label>
        <input
          type="text"
          value={username}
          onChange={(e) => setUsername(e.target.value)}
          required
        />
      </div>
      <div style={{ marginTop: 8 }}>
        <label>Password</label>
        <input
          type="password"
          value={password}
          onChange={(e) => setPassword(e.target.value)}
          required
        />
      </div>
      {error && <div style={{ color: 'red', marginTop: 10 }}>{error}</div>}
      <button type="submit" disabled={loading} style={{ marginTop: 16 }}>
        {loading ? 'Logging in...' : 'Login'}
      </button>
      <div style={{ marginTop: 16 }}>
        Don't have an account? <Link to="/register">Click here</Link>
      </div>
    </form>
  );
};

export default Login;
