document.addEventListener('DOMContentLoaded', () => {
	const form = document.getElementById('contactForm');
	if (!form) return;
	const statusEl = document.getElementById('contactStatus');

	function setStatus(msg, ok) {
		if (!statusEl) return;
		statusEl.textContent = msg;
		statusEl.className = 'status ' + (ok ? 'ok' : 'err');
	}

	form.addEventListener('submit', async (e) => {
		e.preventDefault();
		setStatus('Đang gửi...', true);
		const data = new FormData(form);
			try {
				const resp = await fetch(form.getAttribute('action') || (window.contextPath || '') + '/contact', {
					method: 'POST',
					body: data
				});
				const text = await resp.text();
				let json;
				try { json = text ? JSON.parse(text) : {}; } catch(e){ json = { message: 'Phản hồi không phải JSON: '+ text.substring(0,120) }; }
				if (resp.ok) {
					setStatus(json.message || 'Gửi thành công!', true);
					form.reset();
				} else {
					setStatus(json.message || ('Lỗi ' + resp.status), false);
				}
			} catch (err) {
				setStatus('Lỗi mạng: ' + err.message, false);
			}
	});
});
