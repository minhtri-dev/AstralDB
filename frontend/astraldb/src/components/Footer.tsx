import { Icon } from '@iconify-icon/react';

const Footer = () => {
  return (
    <footer className="bg-[#1c2029] text-white text-center py-4 mt-auto">
      <a
			href="https://github.com/minhtri-dev/AstralDB"
			className="duration-150 hover:text-white"
			target="_blank"
		>
			<Icon icon={"mdi:github"} height={40} />
		</a>
    <p>View on GitHub</p>
    </footer>
  );
};

export default Footer
